#!/bin/bash

# Atualiza a lista de pacotes e instala o Git, o Sudo e o Vim
apt-get update
apt-get install -y sudo vim

# Configura o usuário padrão para ter permissões de sudo sem senha
echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers

# Adiciona um usuário não privilegiado para evitar execução de comandos como root
useradd -m -s /bin/bash myuser
usermod -aG sudo myuser

# Troca para o usuário não privilegiado
su - myuser << EOF

# Configuração do Vim para carregar plugins

# Criação do diretório para plugins do Vim
mkdir -p ~/.vim/pack/github/start

# Clone do repositório do PaperColor
git clone https://github.com/N371/PaperColor ~/.vim/pack/github/start/PaperColor

# Criação do arquivo de configuração do Vim
echo 'syntax enable' >> ~/.vimrc
echo 'set background=dark' >> ~/.vimrc
echo 'colorscheme PaperColor' >> ~/.vimrc

EOF

# Informa ao usuário que a instalação e configuração foram concluídas
echo "Instalação e configuração concluíom sucesso!"

