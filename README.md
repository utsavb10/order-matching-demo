
The project is used with maven build

Locally, sample file is provided to run the project

`
mvn clean install -DskipTests -q assembly:single
java -jar <path_to>/geektrust.jar <absolute_path_to_input_file>
`

Use the above commands to run the project

`
mvn clean install -DskipTests -q assembly:single
java -jar target/geektrust.jar "src/main/resources/input.txt"
`

https://www.baeldung.com/dagger-2
https://proandroiddev.com/dagger-dependencies-beyond-the-basics-53474e48f932
https://github.com/fabioCollini/DaggerDependencies
https://dagger.dev/api/latest/dagger/package-summary.html
https://stackoverflow.com/questions/39953933/dagger-2-two-provides-method-that-provide-same-interface
https://stackoverflow.com/questions/39932780/dagger-2-error-while-getting-a-multiple-instances-of-same-object-with-named
https://stackoverflow.com/questions/40139428/dagger-2-injecting-multiple-objects-of-same-type-using-named-not-working
https://developer.android.com/training/dependency-injection/dagger-basics#java