defmodule Euler2 do
  
  @limit 4_000_000

  def fibo do
    Stream.unfold({1, 2}, fn {a, b} -> {a, {b, a + b}} end)
  end


  def result() do
    fibo |> Enum.take_while(&(&1 < @limit)) |> Enum.filter(&(rem(&1, 2) == 0)) |> Enum.sum()
  end
end

IO.puts("#{Euler2.result()}")
