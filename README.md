# hacker-rank-rest

http://localhost:8080/customers

#### Runtime Argument
-Dlog.level=debug
-Dlog.dir=logs
-Dlog.file=hacker.log

#### Postman file
```
{
	"info": {
		"_postman_id": "115bd3cb-535d-4bf4-921d-76f77d8a1dfa",
		"name": "hacker-rest",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "All Customers",
			"request": {
				"method": "GET",
				"header": [],
				"body": {},
				"url": {
					"raw": "http://localhost:8080/customers",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"customers"
					]
				}
			},
			"response": []
		},
		{
			"name": "Single Customer",
			"request": {
				"method": "GET",
				"header": [],
				"body": {},
				"url": {
					"raw": "http://localhost:8080/customers/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"customers",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Add Customer",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"custId\": 3,\n    \"firstName\": \"Ved\",\n    \"lastName\": \"Singh 3\"\n\t\n}"
				},
				"url": {
					"raw": "http://localhost:8080/customers",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"customers"
					]
				}
			},
			"response": []
		},
		{
			"name": "Remove Customer",
			"request": {
				"method": "DELETE",
				"header": [],
				"body": {},
				"url": {
					"raw": "http://localhost:8080/customers/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"customers",
						"1"
					]
				}
			},
			"response": []
		}
	]
}

```