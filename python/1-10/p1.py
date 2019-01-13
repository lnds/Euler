# This solves Project Euler Problem # 1
sum = 0
for i in range(20):
	if (i % 3) == 0 or (i % 5) == 0:
		sum = sum + i
print(sum)
