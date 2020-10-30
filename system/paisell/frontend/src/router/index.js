import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../components/baseFunction/Home.vue';
import mappingRouter from './mappingRouter'

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

for (const map in mappingRouter) {
  const value = mappingRouter[map]
  const routeConfig = {
    path: '/' + map,
    name: value,
    component: () => import('../components/' + value)
  }
  routes.push(routeConfig)
}

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router;
