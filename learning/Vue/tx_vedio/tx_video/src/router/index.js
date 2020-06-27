import Vue from 'vue';
import VueRouter from 'vue-router';
import RouterMapping from './routerMapping';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home2',
    redirect: '/Home'
  },
  {
    path: '*',
    name: 'home3',
    redirect: '/Home'
  },
  { path: '/Home', name: 'home', component: () => import('../components/Home') }
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
