# def nats(n):
#     yield n
#     yield from nats(n + 1)
#
#
# def sieve(s):
#     n = next(s)
#     yield n
#     yield from sieve(i for i in s if i % n != 0)
#
#
# p = sieve(nats(2))
#
# for i in range(50):
#     print(next(p))
def fibonacci(x, y):
    yield x
    yield from fibonacci(y, x + y)


p = fibonacci(0, 1)

for i in range(50):
    print(next(p))
