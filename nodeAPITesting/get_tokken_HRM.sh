#!/bin/zsh
#
#
#

# USER=XXXXX
# PASSWORD=XXXXXXXXX
# Fill out .env2 with user and pw,  
cat .env2 > .env 

echo -n "ACCESS_TOKEN=" >> .env

node get_api_tokken_HRM.js >> .env
