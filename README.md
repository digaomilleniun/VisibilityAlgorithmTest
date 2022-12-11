# VisibilityAlgorithmTest

Test application created to simulate an inventory control application in a very simplified way for an evaluation.
<p>PS: As this is just a test, a very simple and monolithic architecture was used. The ideal for a closer use to the market would be to separate the application domain into microservices.</p>

## Installation

Just running inside eclipse, STS or IntelliJ

## Usage

Import the Capitole Test.postman_collection.json file that is inside the resources/postman folder inside postman.
Run the upload methods and then run a main call to check the stock of available products.

<p>1: http://localhost:8080/product/upload</p>
<p>2: http://localhost:8080/stock/upload</p>
<p>3: http://localhost:8080/size/upload</p>
<p>4: http://localhost:8080/availableStock?page=0&size=100</p>

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Authors
- [Rodrigo Pires](https://github.com/digaomilleniun)

## License

[MIT](https://choosealicense.com/licenses/mit/)