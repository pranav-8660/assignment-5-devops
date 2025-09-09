# Assignment - Cloud & Linux

This repository contains solutions to three tasks related to **Cloud Services** and **Linux Administration**.

---

## 1. Find out what are all common services available in the cloud.

### Common Cloud Services (Short List)

#### Compute
- Virtual Machines
- Auto Scaling
- Batch Processing

#### Storage
- Object Storage
- Block Storage
- File Storage

#### Databases
- Relational (MySQL, PostgreSQL)
- NoSQL (MongoDB, DynamoDB)
- Data Warehouse

#### Networking
- VPC (Virtual Private Cloud)
- Load Balancer
- CDN

#### Monitoring & Management
- Logging
- Metrics & Alerts
- Cost Management

#### Containers
- Managed Kubernetes (EKS/AKS/GKE)
- Container Registry
- Service Mesh

#### Serverless
- Functions (FaaS)
- Event Bus
- Workflow Orchestration

#### AI & ML
- Vision API
- NLP / Translation
- ML Platform

#### Security
- IAM (Identity & Access Mgmt)
- Key Management (KMS)
- WAF / DDoS Protection

#### Analytics & Big Data
- Stream Processing
- ETL / Data Pipelines
- Spark/Hadoop Clusters

#### DevOps
- CI/CD Pipeline
- Artifact Registry
- Source Repositories

#### IoT
- IoT Hub / Core
- Device Management
- Digital Twins

---

## 2. Write a shell script that prints details of the computer (CPU, memory, disk usage, uptime) and stores it into a log file every 2 minutes.

Below script is in:

pranav@DESKTOP-A0NERDG:/mnt/d/linux_assignment$ ls
log  system_monitor.sh

log directory is where logs are stored.

### Script: system_monitor.sh

#!/bin/bash

LOG_FILE="/mnt/d/linux_assignment/log/cronjob.log"

# Collect system info
{
  echo "System Report at $(date)"
  echo "CPU Info:"
  lscpu | grep "Model name"

  echo -e "\nMemory Usage:"
  free -h

  echo -e "\nDisk Usage:"
  df -h

  echo -e "\nUptime:"
  uptime

  echo
} >> "$LOG_FILE"

### Cronjob Task

*/2 * * * * /mnt/d/linux_assignment/system_monitor.sh

---

### Sample cronjob.log Output

pranav@DESKTOP-A0NERDG:/mnt/d/linux_assignment$ cat log/cronjob.log
System Report at Tue Sep  9 10:16:24 UTC 2025
CPU Info:
Model name:                           AMD Ryzen 5 5625U with Radeon Graphics

Memory Usage:
               total        used        free      shared  buff/cache   available
Mem:           7.4Gi       1.4Gi       4.4Gi        16Mi       1.8Gi       6.0Gi
Swap:          2.0Gi          0B       2.0Gi

Disk Usage:
Filesystem                                Size  Used Avail Use% Mounted on
none                                      3.8G     0  3.8G   0% /usr/lib/modules/6.6.87.2-microsoft-standard-WSL2
none                                      3.8G  4.0K  3.8G   1% /mnt/wsl
none                                      3.8G  572K  3.8G   1% /mnt/wsl/docker-desktop/shared-sockets/host-services
/dev/sdd                                 1007G   57M  956G   1% /mnt/wsl/docker-desktop/docker-desktop-user-distro
drivers                                   244G   89G  156G  37% /usr/lib/wsl/drivers
/dev/sdf                                 1007G  2.0G  954G   1% /
none                                      3.8G  276K  3.8G   1% /mnt/wslg
none                                      3.8G     0  3.8G   0% /usr/lib/wsl/lib
rootfs                                    3.8G  2.7M  3.8G   1% /init
none                                      3.8G  568K  3.8G   1% /run
none                                      3.8G     0  3.8G   0% /run/lock
none                                      3.8G     0  3.8G   0% /run/shm
none                                      3.8G   96K  3.8G   1% /mnt/wslg/versions.txt
none                                      3.8G   96K  3.8G   1% /mnt/wslg/doc
/dev/loop0                                614M  614M     0 100% /mnt/wsl/docker-desktop/cli-tools
C:\                                       244G   89G  156G  37% /mnt/c
D:\                                       233G  778M  232G   1% /mnt/d
tmpfs                                     3.8G   16K  3.8G   1% /run/user/1000
tmpfs                                     3.8G   16K  3.8G   1% /run/user/0
C:\Program Files\Docker\Docker\resources  244G   89G  156G  37% /Docker/host

Uptime:
 10:16:24 up  2:53,  3 users,  load average: 0.17, 0.17, 0.20

(… more log entries continue as script runs every 2 minutes …)

---

## 3. Create a new user in Linux named devops_user, add it to a new group called devops_group, and give it permission to read/write a shared folder.

### Commands

sudo groupadd devops_group

sudo useradd -m -g devops_group devops_user
sudo passwd devops_user
sudo mkdir /shared_folder

sudo chown :devops_group /shared_folder

sudo chmod 770 /shared_folder

### Verify Permissions

root@DESKTOP-A0NERDG:/mnt/d/linux_assignment# ll /shared_folder/
total 8
drwxrwx---  2 root devops_group 4096 Sep  9 16:15 ./
drwxr-xr-x 24 root root         4096 Sep  9 16:15 ../

This confirms that only root and members of devops_group (including devops_user) can access /shared_folder.

---

## Summary
- Task 1: Listed common cloud services.
- Task 2: Created a shell script + cronjob to log system metrics every 2 minutes.
- Task 3: Set up user, group, and shared folder permissions in Linux.
