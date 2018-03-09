List<t>.Clear(); er en standard i IEnumerables for at fjerne alt indhold i en liste

ActiveProductsList.Clear(); er nødvendig for at ikke fylde listen med det samme igen og igen. Konsollen printer de samme ting ud otherwise.

Generic Metode
Skal give fordel for at vise en liste, genbrug
f.eks. i product er dr mange get settere der gør noget af det samme

class Pair<T, U>
{
	public T First {get; set}
	public U Second {get; set;}

	public override string ToString()
	{
		return "{ " + First + ", " + Second + " }";
	}
}

static void main()
{
	Pair<int, int> pairs = new Pair<int, int> {First = 5, Second = 20};

	Pair<string, string> marriage1 = new Pair<String, String> { First = "Suzy", Second = "Frank"};
	Console.WriteLine(marriage1.ToString());


}

private string firstname;
private string lastname;
class User<first, last>
{
	public first First
	{
		get return firstname; 

		set 
		if(value == null)
		{
			throw new ArgumentException("a")
		}
		else
		{
			firstname = value;
		}
	}
	public 
}

class MyGenericClass<T, U>
{
	public string GenStringT;
	public string GenStringU;
}

class Stregsystem
{
	MyGenericClass.GenStringT = "Dan";
	MyGenericClass.GenStringU = "Thomsen";
}

public void DisplayList<Product>(IEnumerable<Product> products, string productname){
	foreach(Product item in products)
}

public void DisplayList<T>(IEnumerable<T> list, string header)
{
	HighLightWriteLine("Displaying" + header);
	foreach(T item in list)
	{
		Console.WriteLine(" " + item);
	}
}