# This guide shows that how to setup the glusterfs storage for HostedEngine testing, and the glusterfs volume replica default at least 3


##Steps:

```
### Install two vm -- centos 7

    1. Close the selinux 

    2. Service firewalld stop 

### Confirm two disks -- one is install the os, another is used to data volume

    1. Install glusterfs(two vm both): 

    2. yum install centos-release-gluster 

    3. yum install -y glusterfs glusterfs-server glusterfs-fuse glusterfs-rdma 

    4. service glusterd start 

 

### two vms both

    1. fdisk /dev/vdb  -------> /dev/vdb1 

    2.  mkfs.xfs -i size=512 /dev/vdb1 

    3.  mkdir -p /data/brick1 

       
    4.	echo '/dev/vdb1 /data/brick1 xfs defaults 1 2' >> /etc/fstab 

    5.  mount -a && mount 

    6.  gluster peer prode vm2 

    7. gluster peer status 

       [root@vm1 ~]# gluster peer status 

                     Number of Peers: 1 
	             Hostname: 10.66.8.213 

		     Uuid: 59f4b3ab-634f-4aa7-ae81-6b23e2ad93a4 

		     State: Peer in Cluster (Connected) 

### Setup the glusterfs volume 

    1. mkdir –p /data/brick1/gv0     (two vms both) 

    2. gluster volume create gv0 replica 2 10.66.10.89:/data/brick1/gv0 10.66.8.213:/data/brick1/gv0   ( only one vm) 

    3. gluster volume start gv0  (only one vm) 

    4. gluster volume info 

       [root@vm1 ~]# gluster volume info 

Volume Name: gv0 

Type: Replicate 

Volume ID: d59632c2-7b23-4d53-867b-f8b4940551df 

Status: Started 

Snapshot Count: 0 

Number of Bricks: 1 x 2 = 2 

Transport-type: tcp 

Bricks: 

Brick1: 10.66.10.89:/data/brick1/gv0 

Brick2: 10.66.8.213:/data/brick1/gv0 

Options Reconfigured: 

transport.address-family: inet 

nfs.disable: on 

performance.client-io-threads: off 

 

 

 

 

### Test: 

On the second host: 

mount -t glusterfs 10.66.8.213:/gv0 data/  (mount successfully) 

```
