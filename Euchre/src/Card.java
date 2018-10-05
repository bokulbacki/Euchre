
public class Card
	{
		private String name;
		private int value;
		private String suit;
		private String owner;
		
		public Card (String na, int v, String s, String o)
			{
				name=na;
				value=v;
				suit=s;
				owner=o;
			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public int getValue()
			{
				return value;
			}

		public void setValue(int value)
			{
				this.value = value;
			}

		public String getSuit()
			{
				return suit;
			}

		public void setSuit(String suit)
			{
				this.suit = suit;
			}

		public String getOwner()
			{
				return owner;
			}

		public void setOwner(String owner)
			{
				this.owner = owner;
			}
	}
