data=$HOME/software/database/no-sql/mongodb-macos-x86_64-4.4.0/data
mkdir -p $data
mongod --replSet my-replica-set --dbpath $data &
mongo --eval "rs.initiate()"