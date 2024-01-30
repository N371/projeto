#!/bin/bash

# Caminho para o arquivo ~/.vimrc
vimrc_file=~/.vimrc

# Verifica se o arquivo ~/.vimrc já existe
if [ -f "$vimrc_file" ]; then
    echo "O arquivo $vimrc_file já existe. Removendo..."
    rm "$vimrc_file"
fi

# Cria um novo arquivo ~/.vimrc com as configurações fornecidas
cat <<EOF > "$vimrc_file"
" Ativar sintaxe colorida
syntax on

" Ativar indentação automática
set autoindent

" Ativar melhor indentação
set smartindent

" Armazenar os ultimos 5000 comandos
set history=5000

" Ativar o número de linhas
set number

" Destaca a linha do cursor
set cursorline

" Ativa o clique do mouse para navegação pelos documentos
set mouse=a

" Ativa compartilhamento de área de trabalho entre o vim e a interface gráfica
set clipboard=unnamedplus

" Converte o tab em espaço em branco ao teclar tab o Vim irá substituir por 2 espaços
set tabstop=2 softtabstop=2 expandtab shiftwidth=2

" Ao teclar a barra de espaço no modo normal, o Vim
" irá colapsar ou expandir o bloco de código do cursor
" foldlevel é a partir de que nível de indentação o
" código iniciará colapsado
set foldmethod=syntax
set foldlevel=99
nnoremap <space> za

" Esquema de cores
colorscheme desert
EOF

echo "Arquivo $vimrc_file criado com sucesso."


echo "" >> ~/.bashrc
echo "# Adicionado pelo script init.sh" >> ~/.bashrc
echo "export PATH=\"./projeto:$PATH\"" 
source ~/.bashrc

echo "Configuracoes executadas"
