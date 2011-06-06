<script src="http://widgets.twimg.com/j/2/widget.js"></script>
<script>
new TWTR.Widget({
  version: 2,
  type: 'profile',
  rpp: 4,
  interval: 6000,
  width: 'auto',
  height: 300,
  theme: {
    shell: {
      background: '#99c2cc',
      color: '#ffffff'
    },
    tweets: {
      background: '#ffffff',
      color: '#7d7d7d',
      links: '#7eb6e6'
    }
  },
  features: {
    scrollbar: true,
    loop: false,
    live: true,
    hashtags: true,
    timestamp: true,
    avatars: false,
    behavior: 'default'
  }
}).render().setUser('${widget.account}').start();
</script>