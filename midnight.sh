
#!/bin/bash

#echo " ROTINA PARA RESTART DO INTRANET - Hora programada 1:00 "
#conteudo=$(/opt/glassfish4/glassfish/bin/asadmin list-applications  --user=admin --passwordfile=/home/intranet/restartintra/logmonkey.txt)

#echo $conteudo

#ocorrencias=$(echo "$conteudo" | egrep -o "^unimed-solutions-ear_[^ ]*")

#echo $ocorrencias


#declare -a ocorrencias
#while IFS= read -r linha; do
#    ocorrencias+=("$linha")
#done < <(echo "$conteudo" | egrep -o "^unimed-solutions-ear_[^ ]*")

#for i in "${!ocorrencias[@]}"; do

#statusApplication=$(/opt/glassfish4/glassfish/bin/asadmin show-component-status ${ocorrencias[$i]} --user=admin --passwordfile=/home/intranet/restartintra/logmonkey.txt)

#echo "Ocorrência: ${ocorrencias[$i]} status: $statusApplication"
#if [[ "$statusApplication" == *enabled* ]]; then

#    echo "Ocorrência: ${ocorrencias[$i]}  ***** será desabilitado e habilitado em seguida *****)."
#    /opt/glassfish4/glassfish/bin/asadmin disable ${ocorrencias[$i]} --user=admin --passwordfile=/home/intranet/restartintra/logmonkey.txt
#    /opt/glassfish4/glassfish/bin/asadmin enable ${ocorrencias[$i]} --user=admin --passwordfile=/home/intranet/restartintra/logmonkey.txt
#else
#    echo "Ocorrência: ${ocorrencias[$i]} não está habilitado (disabled)."
#fi
#done

