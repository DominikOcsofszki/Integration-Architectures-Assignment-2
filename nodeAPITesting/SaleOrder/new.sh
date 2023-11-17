
#/bin/sh
if [ -z $1]
then
		zsh getSaleOrder.sh | grep -i -E "salesrep" 
else
		zsh getSaleOrder.sh | grep -i -E "salesrep" -A $1 
	# zsh getSaleOrder.sh | grep -E "href" | grep -i $1 
	echo "unique Accounts in sales:-----------------------"
	# zsh getSaleOrder.sh | grep -E "href"  |  sort --unique
fi
