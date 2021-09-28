def read_quote(line_number: int):
    quote_file = open("quotes.txt", mode='r')
    for i in range(line_number-1):
        quote_file.readline()
    quote = quote_file.readline()
    quote_file.close()
    return quote


def add_quote(quote: str):
    quote_file = open("quotes.txt", mode='a')
    quote_file.write("\n\""+quote+"\"")
    quote_file.close()
    return


def edit_quote(quote: str, line_number: int):
    quote_file = open("quotes.txt", mode='r')
    lines = []
    count = 0
    flag = True
    while flag:
        line = quote_file.readline()
        if not line:
            flag = False
        else:
            lines.append(line)
    quote_file.close()
    write_file = open("quotes.txt", mode='w')
    for line in lines:
        if count != line_number-1:
            write_file.write(line)
            count += 1
        else:
            write_file.write("\""+quote+"\""+'\n')
            count += 1
    write_file.close()
    return


def number_of_quotes():
    flag = True
    line_file = open('quotes.txt')
    num = 0
    while flag:
        line = line_file.readline()
        if not line:
            flag = False
        else:
            num += 1
    return num


def remove_quote(line_number: int):
    quote_file = open("quotes.txt", mode='r')
    lines = []
    count = 0
    flag = True
    while flag:
        line = quote_file.readline()
        if not line:
            flag = False
        else:
            lines.append(line)
    quote_file.close()
    write_file = open("quotes.txt", mode='w')
    for line in lines:
        if count != line_number - 1:
            write_file.write(line)
            count += 1
        else:
            count += 1


edit_quote("edited quote", 1)

