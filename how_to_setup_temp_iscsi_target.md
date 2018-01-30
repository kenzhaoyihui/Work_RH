# This guide show you how to setup the temp iscsi target, and if you restart the tgtd service , the iscsi target will miss

## Steps:
### Set the temp iscsi target IQN
`tgtadm --lld iscsi --op new --mode target --tid 1 -T iqn.iscsi-2017.com`

 
### Set the storage /dev/sdb or use the dir
`tgtadm --lld iscsi --op new --mode  logicalunit  --tid 1 --lun 1 -b /dev/sdb`
or 
```
dd if=/dev/zero of=/home/yzhao/fs.iscsi.disk bs=1G count=60
tgtadm --lld iscsi --op new --mode  logicalunit  --tid 1 --lun 1 -b /home/yzhao/fs.iscsi.disk
```

 
### Set the access
`tgtadm --lld iscsi --op bind --mode target --tid 1 -I ALL`

 
### Set the Username and Password
`tgtadm --lld iscsi  --mode account --op new  --user yzhao --password redhat`

 
### Binding the User
tgtadm --lld iscsi --mode account --op bind --tid 1 --user yzhao 

 

 
## For client testing
```
Client: 

iscsiadm -m node -T iqn.iscsi-2017.com -o update --name node.session.auth.authmethod --value=CHAP 

iscsiadm -m node -T iqn.iscsi-2017.com --op update --name node.session.auth.username --value=yzhao 

iscsiadm -m node -T iqn.iscsi-2017.com --op update --name node.session.auth.password --value=redhat 

``` 
