#criando imagem do postgreSQL
sudo docker build -t atv-av-listatelefonica-banco ./postgres
sudo docker run -p 5433:5432 -d --name banco atv-av-listatelefonica-banco

#criando a imagem do modulo global
sudo docker build -t atv-av-listatelefonica .
sudo docker run -p 8082:8080 -d --name atv-av-listatelefonica --link banco:host-banco atv-av-listatelefonica
