
#/bin/sh
if [ -z $1]
then
		zsh getSaleOrder.sh | grep -E "href" |   sort --unique 
		echo "add option behind script to search pattern (e.g. account):"
		echo "sh getFromSalesOrderAllWithArg.sh account"  
else
	# zsh getSaleOrder.sh | grep -E "href" | grep -i $1 
	zsh getSaleOrder.sh | grep -E "href" | grep -i $1 |  sort --unique
fi
