target = 999

def sum_div_by(n):
	p = target / n
	return n*(p*(p+1)) / 2

print sum_div_by(3)+sum_div_by(5)-sum_div_by(15)