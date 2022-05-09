# Camel based implementation

### Building

    mvn clean package

### Running Locally

    mvn spring-boot:run

## Running on OpenShift

    mvn oc:deploy

You can expose the service externally using the following command:

    oc expose svc int-sap
