package com.example.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginapp.model.Model;
import com.example.loginapp.model.User;

public class RegistrationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
	}

	public void onSubmitRegistration(View v) {
		// local variables to user in relation to my user class
		String username;
		String username2;
		String password;
		String password2;
		String address;
		String email;
		String phone;

		// declaring EditTexts and setting them to the value of my layout's
		// EditTexts
		EditText usernameField = (EditText) this
				.findViewById(R.id.emailInputField);
		EditText username2Field = (EditText) this
				.findViewById(R.id.username2Field);
		EditText passwordField = (EditText) this
				.findViewById(R.id.passwordField);
		EditText confirmField = (EditText) this.findViewById(R.id.confirmField);
		EditText addressField = (EditText) this.findViewById(R.id.addressField);
		EditText emailField = (EditText) this.findViewById(R.id.emailField);
		EditText phoneField = (EditText) this.findViewById(R.id.phoneField);

		// comes back as text object - converts to string
		username = usernameField.getText().toString();
		username2 = username2Field.getText().toString();
		password = passwordField.getText().toString();
		password2 = confirmField.getText().toString();
		address = addressField.getText().toString();
		email = emailField.getText().toString();
		phone = phoneField.getText().toString();

		// get instance of model and user
		Model m = Model.getInstance();
		User u = m.findUserByUsername(username);
	}

		// if there is no user that exists with username and both passwords
		// match - user will be created
		/*if (u == null && password.equals(password2)) {
			u = new User(username, username2, password, address, email, phone,
					"hi, my name is " + username);
			// add user
			m.addUser(u);
			

			Toast.makeText(this, "Registration Complete", Toast.LENGTH_LONG)
					.show();
			// close the activity
			finish();
		} else {
			Toast.makeText(this, "You have errors", Toast.LENGTH_LONG).show();
		}

	}
	*/

	public void onCancelRegistration(View v) {
		finish();
	}
}
