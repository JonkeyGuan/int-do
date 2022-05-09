cd ../
mvn clean package -DskipTests

cd env
oc start-build int-do --from-dir=../target/ -F
