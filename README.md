
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

