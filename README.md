In just case . make theese command (mvn clean package) and (docker compose build --no-cache) to run (docker compose up)
  
To start making request, need to wait until the services register in Eureka or wait until tis appears in Docker logs
eureka-server    | 2025-10-03T14:33:19.108Z  INFO 1 --- [eureka-server] [a-EvictionTimer] c.n.e.registry.AbstractInstanceRegistry  : Running the evict task with compensationTime 0ms
