## Merchant Signup Service

### LIST All REQUEST
- URL : <u>http://localhost:8080/merchant/listMerchants</u>
- RequestMethod : POST
- BODY : NA

### Add REQUEST
- URL : <u>http://localhost:8080/merchant/add</u>
- RequestMethod : POST
- BODY : 

~~~json
 {
        "merchantId": "002",
        "merchantName": "BTC",
        "merchantCategory": "Transport",
        "merchantStAddress": "Chaka",
        "merchantCity": "Katni",
        "merchantState": "MP",
        "merchantZipCd": "483501",
        "merchantContactPerson": "Shivbabu",
        "merchantContactPersonNbr": "9893059016"
}
~~~

### Get Merchant by ID REQUEST
- URL : <u>http://localhost:8080/merchant/getMerchant</u>
- RequestMethod : POST
- BODY : 

~~~json
{
		"merchantId": 4
}
~~~

