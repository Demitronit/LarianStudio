import{createRouter, createWebHistory} from 'vue-router';
import Mane from './page/Mane.vue';
import Vhod from './page/Vhod.vue';
import Reg from './page/Reg.vue';
import User from './page/User.vue';

export default createRouter({
history: createWebHistory(),
routes: [
    {path: "/home", component: Mane, alias: '/'},
    {path: "/signup", component: Vhod},
    {path: "/signin", component: Reg},
    {path: "/account", component: User},
]
});