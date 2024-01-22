#!/bin/bash

apt-get update
apt-get upgrade -y
apt-get install sudo -y
apt-get install curl -y
apt-get install vim -y

curl -fLo ~/.vim/autoload/plug.vim --create-dirs \
    https://raw.githubusercontent.com/junegunn/vim-plug/master/plug.vim

git clone https://github.com/NLKNguyen/papercolor-theme.git ~/.vim/bundle/papercolor-theme

cat <<EOL > ~/.vimrc
set nocompatible
filetype off

call plug#begin('~/.vim/plugged')

Plug 'NLKNguyen/papercolor-theme'

call plug#end()

colorscheme PaperColor
EOL

# Execute o PluginInstall no vim
vim +PlugInstall +qall

echo "Instalação e configuração concluíom sucesso!"

