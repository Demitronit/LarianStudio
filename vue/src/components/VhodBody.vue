
<script>
import api from "./api/api.js";
export default {
  data() {
    return {
      user_id: [],
      name: '',
      errorMessage: "",
      responseData: null,
      password: '',
      showPassword: false,
      passwordError:'', 
      loginError:'' 
    };
  },
  computed: {
    inputType() {
      return this.showPassword ? "text" : "password";
    },
  },
  methods: {
    toggleVisibility() {
      this.showPassword = !this.showPassword;
      this.$refs.passwordInput.focus(); // Фокусируемся на поле ввода после переключения
    },
  
  async signinUser() { 
    console.log(123);
      const User = { 
        name: this.name, 
        password: this.password 
      } 
      if (this.name.length ==0 ) { 
        this.loginError = true; 
        this.errorMessage = "Неправильный логин"; 
        return; 
      }else{this.loginError = false;} 
      if (this.password.length ==0 ) { 
        this.passwordError = true; 
        this.errorMessage = "Пароль не верный"; 
        return; 
      }else{this.passwordError = false;} 
      try { 
        const response = await api.post('/auth/signin', User); 
        console.log('Успешно авторизован:',User); 
        window.location.href ="/account"; 
      } catch (error) {     
    } 
  }
},
};

</script>


<template>
  <div>
    <p>Вход в аккаунт: </p>
    <div class="pole">
      <input v-model="name" placeholder="Логин" />
      <input ref="passwordInput":type="inputType" v-model="password" placeholder="Введите пароль"/>
      <div class="pole1">
        <button @click="toggleVisibility">
          {{ showPassword ? "Скрыть" : "Показать" }}
        </button>
        </div>
    </div>
    <div class="vhod">
    <button @click="signinUser">Готово</button>
  </div>
  </div>
</template>

<style>



.vhod{
  margin-top: 10px;
  
}

.pole1{
    display: flex;
}

.pole{
    margin-top: 10px;
    width: 174px;
    display: flex;
    flex-direction: column;
}
input{
    margin-bottom: 10px;
}
</style>