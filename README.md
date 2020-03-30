# vending_machine
program to mock a vending machine

## The Solution
Using a Java8 `BlockingQueue` for simulating the vending machine queue of products and a Runnable to attend every request from the user I built a Simple JavaApplication that runs in `main()`.

## The Code
It contains a Product `class` with 2 attributes: the product 'name' and the 'preparation time', the App class contains a `main` method where 3 products are created, inside the 'user' thread is a `optionDialog` with the 3 products and a Exit option whom execute a `System.exit(0)`, the user selects a product and it is put into the Queue and the Vending Machine `Runnable` takes the product and wait the preparation time. The system prints in console when the product is set into Queue and when the vending machine Thread finnish to process.

## To run

Requirements: Java 8 or heigher

For easy run and to see the console messages that tells when a product is ordered and when is done, add the project to a IDE like Netbeans, IntelliJ Idea or Eclipse and run.
