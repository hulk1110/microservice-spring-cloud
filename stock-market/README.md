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
