# testebrasprev
Developer Test from Brasprev

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
