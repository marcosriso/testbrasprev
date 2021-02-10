# testebrasprev
Developer Test from Brasprev

## Deployed at AWS cloud using Docker.
First of all, create an user using POSTMAN, just make a post call to:

[POST] http://ec2-3-208-24-30.compute-1.amazonaws.com:8080/api/v1/user

{
	"username": "yourusername",
	"password": "yourpass"
}

Then, login at 
http://ec2-3-208-24-30.compute-1.amazonaws.com:8080/api/v1/login

With the same object.

Then add the header authorization to your calls, with the HEADER authorization that is returned from the server.
I'm using JWT for authentication.

Then, make a GET call to:

[GET] http://ec2-3-208-24-30.compute-1.amazonaws.com:8080/api/v1/users

Try adding or deleting clients, as the information below details.


### Automated Tests:
Added 4 simple unit tests for demonstration purposes.

## Configurations
Clone the project and then run mvn clean install from the command line. Then run springboot with mvn spring-boot:run
You should have a postgresql database installed.

## API Endpoints
create your user with a post to /api/v1/user
{
	"username": "username",
	"password": "yourpass"
}

Then, login at /api/v1/user with the very same payload. Get the authentication JWT and include into the header of your api calls.

* GET /api/v1/users (list users)
* GET /api/v1/clients (list users)
* POST /api/v1/[user or client]/{id} (List one by Id)
* POST /api/v1/client (create a client)
* POST /api/v1/[user or client]/update/{id}
* POST /api/v1/[user or client]/delete/{id}

* I could have used the term "Customer" instead of Client. But in a rush I didn't payed attention to that.

- When updating or deleting users, you must send the object including password, but ID is not needed.
