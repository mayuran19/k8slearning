1. Install postgresql
brew install postgres

2. Start postgresql service
brew services start postgresql

3. Login to postgres database to create database and users
psql postgres

4. Create role for appuser
create role appuser with login password 'password';

5. Create database for inventory
create database inventory;

6. Grant appuser all access to inventory database
grant ALL privileges on database inventory to appuser;


7. Create database for product
create database product;

8. Grant appuser all access to product database
grant ALL privileges on database inventory to appuser;

9. Create a new namespace to keep all our application
kubectl apply -f namespace-k8slearning.yaml





Noted:
Finding service
1. By environment variable
2. By using DNS