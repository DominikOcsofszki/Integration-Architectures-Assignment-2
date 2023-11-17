#!/bin/zsh


curl -X GET $(cat salesOrderLink.txt) \
		-H "accept: application/json"\
		--user $(cat userPW.txt) | json_pp
