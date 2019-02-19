function HelloAlert(message) {
    alert(message);
}
HelloAlert("HELLO");
// HelloAlert(22);
var Person = /** @class */ (function () {
    function Person(kkk) {
        this.products = []; // any array type when done like this
        this.Name = kkk;
    }
    Object.defineProperty(Person.prototype, "lastName", {
        // Getter
        get: function () {
            return this.lastname;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "Name", {
        // Setter
        set: function (newName) {
            this.name = newName;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "Phone", {
        set: function (value) {
            if (value.toString().length <= 6) {
                this.phoneNo = value;
            }
            else if (value.toString().length > 6) {
                this.phoneNo = 0;
            }
        },
        enumerable: true,
        configurable: true
    });
    return Person;
}());
var Product = /** @class */ (function () {
    function Product() {
    }
    return Product;
}());
