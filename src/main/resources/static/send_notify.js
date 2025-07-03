window.addEventListener("DOMContentLoaded", function () {
    fetch('/channel')
        .then(response => {
            if (!response.ok) throw new Error('Erro na requisição /channel');
            return response.text();
        })
        .then(channel => {
            channel = channel.toLowerCase();
            if (channel === 'whatsapp') {
                document.getElementById('send_whatsapp').style.display = 'inline-block';
            } else if (channel === 'email') {
                document.getElementById('send_email').style.display = 'inline-block';
            } else {
                console.warn("Canal não reconhecido:", channel);
            }
        })
        .catch(error => {
            console.error("Erro ao buscar canal:", error);
        });

    handleFormSubmit("form_whatsapp", ["telefone", "mensagem_whatsapp"]);
    handleFormSubmit("form_email", ["email", "mensagem_email"]);
});

function handleFormSubmit(formId, fields) {
    const form = document.getElementById(formId);
    if (!form) return;

    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const data = {};
        let valid = true;

        fields.forEach(fieldId => {
            const input = document.getElementById(fieldId);
            if (!input.checkValidity()) {
                input.style.border = "2px solid red";
                valid = false;
            } else {
                input.style.border = "2px solid green";
                if (input.name === "to") {
                    data.to = input.value;
                } else if (input.name === "message") {
                    data.message = input.value;
                }
            }
        });

        if (!valid) return;

        fetch("/notify", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(res => {
                if (!res.ok) {
                    return res.text().then(text => {
                        console.error("Erro do servidor:", text);
                        throw new Error(text);
                    });
                }
                return res.text();
            })
            .then(link => {
                alert("Mensagem enviada com sucesso!");

                fields.forEach(fieldId => {
                    const input = document.getElementById(fieldId);
                    input.value = "";
                    input.style.border = ""; // opcional: remove a borda verde
                });

                window.open(link, '_blank');
            })
            .catch(err => {
                console.error("Erro ao enviar mensagem:", err);
                alert("Erro ao enviar a mensagem.");
        });
    });
}
