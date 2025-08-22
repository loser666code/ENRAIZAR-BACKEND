document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('formColaborador');
  const cpfInput = document.getElementById('cpfColaborador');
  const dataInput = document.getElementById('dataNascimentoColaborador');

  // ----- Máscara do CPF -----
  cpfInput.addEventListener('input', (e) => {
    let value = e.target.value.replace(/\D/g, ""); // só números
    value = value.slice(0, 11); // limita a 11 dígitos

    if (value.length > 9) {
      value = value.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
    } else if (value.length > 6) {
      value = value.replace(/(\d{3})(\d{3})(\d+)/, "$1.$2.$3");
    } else if (value.length > 3) {
      value = value.replace(/(\d{3})(\d+)/, "$1.$2");
    }

    e.target.value = value;
  });

  // ----- Validação do CPF -----
  function validarCPF(cpf) {
    cpf = cpf.replace(/\D/g, "");
    if (cpf.length !== 11 || /^(\d)\1+$/.test(cpf)) return false;

    let soma = 0, resto;

    // Primeiro dígito verificador
    for (let i = 1; i <= 9; i++) soma += parseInt(cpf.substring(i-1, i)) * (11 - i);
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    if (resto !== parseInt(cpf.substring(9, 10))) return false;

    soma = 0;
    // Segundo dígito verificador
    for (let i = 1; i <= 10; i++) soma += parseInt(cpf.substring(i-1, i)) * (12 - i);
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    if (resto !== parseInt(cpf.substring(10, 11))) return false;

    return true;
  }

  cpfInput.addEventListener('blur', () => {
    if (cpfInput.value && !validarCPF(cpfInput.value)) {
      alert("CPF inválido. Verifique e digite novamente.");
      cpfInput.value = "";
      cpfInput.focus();
    }
  });

  // ----- Máscara simples de data (YYYY-MM-DD) -----
  dataInput.addEventListener('input', (e) => {
    let value = e.target.value.replace(/\D/g, "");
    if (value.length > 4 && value.length <= 6) {
      value = value.replace(/^(\d{4})(\d+)/, "$1-$2");
    } else if (value.length > 6) {
      value = value.replace(/^(\d{4})(\d{2})(\d+)/, "$1-$2-$3");
    }
    e.target.value = value;
  });

  // ----- Validação de data -----
  function validarData(dateStr) {
    if (!/^\d{4}-\d{2}-\d{2}$/.test(dateStr)) return false;
    const date = new Date(dateStr);
    const [ano, mes, dia] = dateStr.split("-").map(Number);
    return (
      date.getFullYear() === ano &&
      date.getMonth() + 1 === mes &&
      date.getDate() === dia
    );
  }

  // ----- SUBMIT DO FORM -----
  form.addEventListener('submit', async function (e) {
    e.preventDefault();

    const nome = document.getElementById('nomeColaborador').value.trim();
    const sobrenome = document.getElementById('sobreNomeColaborador').value.trim();
    const dataNascimento = dataInput.value.trim();
    const cpf = cpfInput.value.trim();
    const email = document.getElementById('emailColaborador').value.trim();
    const setorValue = document.getElementById('setorColaborador').value.trim();
    const senha = document.getElementById('senhaColaborador').value;

    // validações extras
    if (!validarCPF(cpf)) {
      alert("CPF inválido. Corrija antes de enviar.");
      return;
    }
    if (!validarData(dataNascimento)) {
      alert("Data de nascimento inválida. Use o formato YYYY-MM-DD.");
      return;
    }

    try {
      let setorId = parseInt(setorValue);
      if (Number.isNaN(setorId)) {
        // tenta resolver por nome
        const setResp = await fetch('http://localhost:8080/api/setores');
        const setores = await setResp.json();
        const match = setores.find(s => (s.nomeSetor || '').toLowerCase() === setorValue.toLowerCase());
        if (!match) { alert('Setor não encontrado. Use o ID ou um nome válido.'); return; }
        setorId = match.id;
      }

      const resp = await fetch('http://localhost:8080/api/usuarios', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          nomeCompleto: `${nome} ${sobrenome}`,
          email: email,
          senha: senha,
          tipoUsuario: 'COLABORADOR',
          setorId: setorId,
          cpf: cpf.replace(/\D/g, ""), // envia apenas números
          dataNascimento: dataNascimento
        })
      });

      if (!resp.ok) throw new Error(await resp.text());
      alert(`Colaborador criado: ${nome} ${sobrenome}`);
      window.location.href = '../Adm/adm.html';
    } catch (err) {
      console.error(err);
      alert('Falha ao criar colaborador: ' + err.message);
    }
  });
});
