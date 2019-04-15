function HelloAlert(message: string){
	alert(message);
}

HelloAlert("HELLO");
// HelloAlert(22);

class Person {
	private name;
	private lastname: string;
	private phoneNo: number;
	public mail;
	products: Product[] = []; // any array type when done like this
	miscArray = [];


	constructor(kkk : string){
		this.Name = kkk;
	}

	// Getter
	get lastName(){
		return this.lastname;
	}

	// Setter
	set	Name(newName: string){
		this.name = newName
	}

	set Phone(value: number){
		if(value.toString().length <= 6) {
			this.phoneNo = value;
		}
		else if(value.toString().length > 6){
			this.phoneNo = 0;
		}
	}
}

// Instantiate a class
let person1 = new Person("Jacob");
// Use a setter
person1.Name = "Georgios";
// Add different types to array through instantiated Person class
person1.miscArray.push(45);
person1.miscArray.push("This is a medium length string");

/*

// Add a Product instantiation to the products array in Person
let product1 = new Product("Orange", "A juicy orange", 5.95); // cannot make a new instantiation of a class before it is declared
person1.products.push(product1);

*/
class Product {
	title: string;
	desc: string;
	price: number;

	constructor(title: string, desc: string, price: number){
		this.title = title;
		this.desc = desc;
		this.price = price;
	}
}

// Direct push to array
person1.products.push(new Product("Apple", "A juicy apple", 4.95));

// needs to implement serial variable and beBored() method
class FactoryOperator implements ISupplier{
	private firstName: string;
	private id: number;
	serial: string;

	constructor(newFirstName: string, newId: number, supplierSerial: string){
		this.FirstName = newFirstName;
		this.Id = newId;
		this.Serial = supplierSerial;
	}

	set FirstName(fn: string){
		this.firstName = fn;
	}

	set Id(newId: number){
		this.id = newId;
	}

	set Serial(newSerial: string){
		this.serial = newSerial;
	}

	beBored(){
		alert("FactoryOperator is now Bored!");
	}

}

interface ISupplier {
	serial: string;
	beBored();
}