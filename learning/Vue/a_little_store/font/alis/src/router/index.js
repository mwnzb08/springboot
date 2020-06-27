import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import RouterMapping from './router'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '*',
    name: 'redirect',
    redirect: '/404'
  }
];

for (const map in RouterMapping) {
  const value = RouterMapping[map];
  const routerConfig = {
    path: '/' + map,
    name: value,
    component: () => import('../components/' + value)
  };
  routes.push(routerConfig);
}

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
