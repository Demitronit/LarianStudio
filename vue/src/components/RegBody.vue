
<script>
import api from "./api/api.js";
export default {
  data() {
    return {
      showPassword: false,
      user_id: [],
      login: '',
      password: '',
      name: '',
      age: 0,
      errorMessage: ''
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
  
    async signupUser() {
      const newUser = {
        name: this.name,
        age: this.age,
        login: this.login,
        password: this.password
      }
      try {
        const response = await api.post('/auth/signup', newUser);
        console.log('Успешно зарегистрирован:', newUser);
        window.location.href ="/account";
      } 
      catch (error){
        if (error.response || error.response.status !== 401) {
          this.errorMessage ="Ошибка на стороне сервера!!!"
        }
        else{
          this.errorMessage ="Ошибка авторизации! Проверьте логин и пароль"
        }
        console.log(this.name);
      }
    },
},
};


</script>


<template>
  <div>
    <p>Здравствуй: {{ name }} </p>
    <div class="pole">
      <input type="text" placeholder="Ваше Имя" v-model="name"/>
      <input type="number" placeholder="Возраст" v-model="age" />
      <input type="text" placeholder="Логин" v-model="login"/>
      <input  ref="passwordInput":type="inputType" v-model="password" placeholder="Введите пароль"/>
      <div class="pole1">
        <button @click="toggleVisibility">

          {{ showPassword ? "Скрыть" : "Показать" }}
        </button>
    </div>
    </div>
  </div>
  <div class="gotovo">
    <button @click="signupUser">Готово</button>
  </div>
</template>

<style>
.gotovo{
  margin-top: 10px;
}

.pole1{
  display: flex;
}

.pole{
  width: 174px;
  display: flex;
  flex-direction: column;
}
input{
  margin-bottom: 10px;
}
</style>