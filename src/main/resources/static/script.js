async function generateQRCode() {
  const text = document.getElementById('textInput').value;
  const qrResult = document.getElementById('qrResult');
  const downloadBtn = document.getElementById('downloadBtn');

  if (!text.trim()) {
    alert("Digite algo para gerar o QR Code.");
    return;
  }

  qrResult.innerHTML = '<div class="loader"></div>';
  downloadBtn.style.display = 'none';

  try {
    const response = await fetch('http://34.200.237.15:8080/qrcodegenerator', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ text })
    });

    if (!response.ok) {
      throw new Error("Erro ao gerar o QR Code");
    }

    const data = await response.json();
    qrResult.innerHTML = `<img id="qrImage" src="${data.url}" alt="QR Code gerado" />`;

    downloadBtn.style.display = 'inline-block';

    downloadBtn.onclick = async () => {
      const imageResp = await fetch(data.url);
      const blob = await imageResp.blob();
      const url = window.URL.createObjectURL(blob);

      const a = document.createElement('a');
      a.href = url;
      a.download = 'qrcode.png';
      document.body.appendChild(a);
      a.click();
      a.remove();
      window.URL.revokeObjectURL(url);
    };

  } catch (error) {
    qrResult.innerHTML = '';
    alert("Ocorreu um erro ao gerar o QR Code.");
  }
}