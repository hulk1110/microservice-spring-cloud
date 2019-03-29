using db-service
---------------------------------------------------------------------

creating a user entry:

use postman with post request:

http://localhost:8300/rest/db/add

set header as --> content-type:application/json
pass  raw body as:

{
	"userName":"Nishant",
	"quotes":["GOOG"]
}


to get :-> http://localhost:8300/rest/db/Nishant

to delete:-> http://localhost:8300/rest/db/delete/Nishant

using stock service :
----------------------------------------------------------------------------

use the get service as:

http://localhost:8301/rest/stock/Nishant


once proxy is set :

we are supposed to use below urls to access respective services:

http://localhost:8761/api/stock-service/rest/stock/nishant

http://localhost:8761/api/db-service/rest/db/Nishant

note :since eureka is made api gateway also, we can make use of above url always to hit from front end.
