package grenouilloland.modele;




/**
 * Type enumere fortement type permettant une strategie sur les nenuphar.
 * @author Alexis Prevost Mayhen
 * @author Guillaume Drouart
 * @author Lucas Gouedant
 * @author Nicolas Vatel
 */
public enum TypeElement{

    EAU{
        @Override
        public void effetSurGrenouille(Grenouille gr)
        {
            gr.mourir();
        }
    },

	NENUPHARIMMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			//rien
		}
	},



    NENUPHAR{
        @Override
        public void effetSurGrenouille(Grenouille gr)
        {
            //rien
        }
    },

	NENUPHARVENENEUX{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			if(gr.estMalade())
			{
				gr.mourir();
			}
			else
			{
				gr.estMalade();
				gr.setPtVie(gr.getPtVie()/2);
			}
		}
	},

	NENUPHARNUTRITIF{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			gr.setPtVie(gr.getPtVie()+1);
			gr.guerir();
		}
	},

	NENUPHARDOPANT{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			gr.setPtVie(gr.getPtVie()*2);
			gr.guerir();
		}
	},

	NENUPHARMORTEL{
        @Override
		public void effetSurGrenouille(Grenouille gr)
		{
			gr.mourir();
		}
	};

	public abstract void effetSurGrenouille(Grenouille gr);

	public static TypeElement auHasard(){
        int nbRand = (int)(Math.random()*(values().length-2))+2;
        return values()[nbRand];
	}



}

