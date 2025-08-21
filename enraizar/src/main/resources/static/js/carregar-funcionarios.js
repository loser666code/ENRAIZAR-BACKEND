async function carregarFuncionarios() {
    try {
        const response = await fetch('http://localhost:8080/funcionarios');
        if (!response.ok) {
            throw new Error("falha em carregar funcionarios")
        }
        const funcionarios = await response.json();
        const container = document.getElementById('funcionarios')
        if (funcionarios.length === 0) {
            container.innerHTML = '<p>nenhum funcionario encontrado!<p>';
            return;
        }
        funcionarios.array.forEach(func => {
            const div = document.createElement('div');
            div.className = 'funcionarios';
            div.innerHTML = `
                        
                        <strong>Nome:</strong> <span>${func.nome}</span>
                        <strong>Sobrenome:</strong><span>${func.sobrenome}</span>
                        <strong>Email:</strong> <span>${func.email}</span>
                        <strong>Data Nascimento:</strong> <span>${new Date(func.data_nascimento).toLocaleDateString('pt-BR')}</span>
                        <strong>CPF:</strong> <span>${func.cpf}</span>
                        <strong>Tipo de Usuario:</strong> <span>${func.tipo_usuario}</span>
                        <strong>Criado em:</strong> <span>${new Date(func.cratead_at).toLocaleDateString('pt-BR')}</span>
            `
            container.appendChild('div')
        });
    } catch (error) {
        document.getElementById('funcionarios').innerHTML =
            `<p style="color: red;">Erro ao carregar funcionários: ${error.message}</p>`;
    }
}

carregarFuncionarios();