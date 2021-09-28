from random import random

from flask import Flask, request, jsonify
from quote_utilities import read_quote, edit_quote, number_of_quotes, add_quote, remove_quote

app: Flask = Flask(__name__)


@app.get('/test')
def test():
    return "The service is running properly and you can access it"


@app.get('/quote')
def get_quote():
    quote = read_quote(int(random()*number_of_quotes())+1)
    return quote


@app.get('/quote/<quote_number>')
def get_specific_quote(quote_number: str):
    quote = read_quote(int(quote_number))
    return quote


@app.post('/quote')
def post_quote():
    add_quote(request.json['quote'])
    return "yeet", 201


@app.patch('/quote/<quote_number>')
def patch_quote(quote_number: int):
    print(request.json['quote']+f' {quote_number}')
    edit_quote(request.json['quote'], int(quote_number))
    return "yeet", 201


@app.delete('/quote/<quote_number>')
def delete_quote(quote_number: int):
    remove_quote(int(quote_number))
    return "yeet"


if __name__ == '__main__':
    app.run()