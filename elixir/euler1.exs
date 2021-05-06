defmodule Euler1 do
  @target 1000
  @a 3
  @b 5
  
  def sum(n, m) do
    Enum.filter(1..n-1, &(rem(&1, m)==0)) |> Enum.sum()
  end

  def result(), do: sum(@target, @a) + sum(@target, @b) - sum(@target, @a * @b)
end

IO.puts("#{Euler1.result()}")
