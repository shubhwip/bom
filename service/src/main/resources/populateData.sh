
## Test Environment
curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service1",
	"serviceVersion":"1.0.1",
	"environment":"test",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service2",
	"serviceVersion":"1.0.2",
	"environment":"test",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service3",
	"serviceVersion":"1.0.3",
	"environment":"test",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service4",
	"serviceVersion":"1.0.4",
	"environment":"test",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service5",
	"serviceVersion":"1.0.5",
	"environment":"test",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

### Pre Production

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service1",
	"serviceVersion":"2.0.1",
	"environment":"preproduction",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service2",
	"serviceVersion":"2.0.2",
	"environment":"preproduction",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service3",
	"serviceVersion":"2.0.3",
	"environment":"preproduction",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service4",
	"serviceVersion":"2.0.4",
	"environment":"preproduction",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service5",
	"serviceVersion":"2.0.5",
	"environment":"preproduction",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

##### Production

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service1",
	"serviceVersion":"3.0.1",
	"environment":"production",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service2",
	"serviceVersion":"3.0.2",
	"environment":"production",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service3",
	"serviceVersion":"3.0.3",
	"environment":"production",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service4",
	"serviceVersion":"3.0.4",
	"environment":"production",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'

curl --location --request POST 'http://localhost:8081/bom-api/boms/create' \
--header 'Content-Type: application/json' \
--data-raw '{
	"serviceName":"dummy-service5",
	"serviceVersion":"3.0.5",
	"environment":"production",
	"versionControlCheckoutHash":"ckjdncjkndjcndjkcnkjdncjkdn1",
	"commitAuthor":"Kapil Jain"
}'