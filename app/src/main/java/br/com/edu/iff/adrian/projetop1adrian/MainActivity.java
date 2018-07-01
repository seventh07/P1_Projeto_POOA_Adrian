package br.com.edu.iff.adrian.projetop1adrian;

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
                String login = etLogin.toString();
                String senha = etSenha.toString();
                if (usuario.Logar(login,senha) == null){
                    Log.d("Resultado do Login","Usuário não encontrado!");
                }else{
                    Log.d("Resultado do Login","Usuário encontrado e carregado!");
                }
            }
        });
    }
}
