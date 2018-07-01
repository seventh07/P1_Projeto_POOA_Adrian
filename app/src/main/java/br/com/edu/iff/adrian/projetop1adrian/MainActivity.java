package br.com.edu.iff.adrian.projetop1adrian;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.edu.iff.adrian.model.Usuario;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etLogin = (EditText) findViewById(R.id.etLogin);
        final EditText etSenha = (EditText) findViewById(R.id.etSenha);
        Button bLogar = (Button)  findViewById(R.id.bLogar);

        bLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                String login = etLogin.getText().toString();
                String senha = etSenha.getText().toString();
                String mensagem = "";
                mensagem = logar(login,senha);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setMessage(mensagem);
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
        });
    }

    public String logar(String login, String senha){
        Realm realm = Realm.getDefaultInstance();
        Usuario usuarioBusca = new Usuario();
        Usuario usuario = new Usuario();
        String mensagem = "";
        if (login != null){
            usuario = usuarioBusca.findByLogin(login);
            if (usuario != null) {
                if (usuario.getSenha() != null && senha != null) {
                    if (usuario.getSenha().equals(senha)) {
                        Log.d("Resultado do Login", "Usuário encontrado e carregado!");
                    } else {
                        Log.d("Resultado do Login","Senha incorreta!");
                    }
                } else {
                    Log.d("Resultado do Login","Erro na senha cadastrada/Senha inválida!");
                }
            }else{
                mensagem = "Usuário não encontrado!";
                Log.d("Resultado do Login","Usuário não encontrado!");
            }
        }else{
            Log.d("Resultado do Login","Usuário inválido!");
        }
        return mensagem;
    }
}
